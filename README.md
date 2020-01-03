# zio-repeat-as-resource

Program output:
```
19:22:16.265 [zio-default-async-1-836514715] INFO net.zipec.ziorepeat.TestApp$ - creating resource 1
19:22:16.313 [zio-default-async-1-836514715] INFO net.zipec.ziorepeat.TestApp$ - creating resource 2
19:22:16.404 [zio-default-async-1-836514715] INFO net.zipec.ziorepeat.TestApp$ - creating resource 3
19:22:16.484 [zio-default-async-2-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
19:22:17.722 [zio-default-async-3-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
19:22:18.723 [zio-default-async-4-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
19:22:19.725 [zio-default-async-5-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
attempting gracefull shutdown (SIGINT)
19:22:20.537 [zio-default-async-6-836514715] INFO net.zipec.ziorepeat.TestApp$ - cleaning resource 3
19:22:20.539 [zio-default-async-6-836514715] INFO net.zipec.ziorepeat.TestApp$ - cleaning resource 2
19:22:20.747 [zio-default-async-7-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
19:22:21.752 [zio-default-async-8-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
19:22:22.755 [zio-default-async-9-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
19:22:23.757 [zio-default-async-10-836514715] INFO net.zipec.ziorepeat.TestApp$ - working
keeps printing until forced shutdown (SIGKILL)
```