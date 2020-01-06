package net.zipec.ziorepeat

import cats.effect.Resource
import com.typesafe.scalalogging.StrictLogging
import zio.clock.Clock
import zio.duration.{Duration => ZioDuration}
import zio.interop.catz._
import zio.{Fiber, Schedule, Task, ZIO}

import scala.concurrent.duration._

object TestApp extends CatsApp with StrictLogging {

  override def run(args: List[String]): ZIO[Any, Nothing, Int] = {
    program
      .use(_ => Task.never)
      .fold(_ => 1, _ => 0)
  }

  def log(msg: String): Task[Unit] = Task.effect(logger.info(msg))

  def program: Resource[Task, Unit] = {
    for {
      _ <- Resource.make[Task, Unit](log("creating resource 1"))(_ => log("cleaning resource 1"))
      _ <- Resource.make[Task, Fiber[Throwable, Int]] {
        for {
          _ <- log("creating resource 2")
          fiber <- log("working")
            .repeat(Schedule.spaced(ZioDuration.fromScala(1.second)))
            .provide(Clock.Live)
            .fork
            .interruptible // this fixed my issue
        } yield fiber
      } { fiber =>
        for {
          _ <- log("cleaning resource 2")
          exit <- fiber.interrupt
          _ <- log(s"cleaned resource 2 with ${exit.toEither}")
        } yield ()
      }
      _ <- Resource.make[Task, Unit](log("creating resource 3"))(_ => log("cleaning resource 3"))
    } yield ()
  }

}
