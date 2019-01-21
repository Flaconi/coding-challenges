# DevOps Engineer: Docker


Design and implement a *high available[\[1\]](#1-high-available)* infrastructure with Docker and Docker Compose similar
to the sketch below.


```
                             +----------+                    +----------+
                             |          |                    |          |
                             |    FE    |                    |    BE    |
                            /|          |\                  /|          |\
                           / +----------+ \                / +----------+ \
             +----------+ /                \ +----------+ /                \ +----------+
 http/https  |          |/                  \|          |/                  \|          |
>------------|    LB    |                    |    LB    |                    |    DB    |
             |          |\                  /|          |\                  /|          |
             +----------+ \                / +----------+ \                / +----------+
                           \ +----------+ /                \ +----------+ /
                            \|          |/                  \|          |/
                             |    FE    |                    |    BE    |
                             |          |                    |          |
                             +----------+                    +----------+
```


## Required functionality:

* You need to have at least two FE's[\[2\]](#2-fe)
* You need to have at least two BE's[\[3\]](#3-be)
* Database must have persistant storage
* Host OS must be able to access the application via http or https


## Technical constraints:

* You can make use of official Docker images
* [FE](data/fe/) and [BE](data/be/) applications as well as MySQL [dummy data](data/sql/) is provided
* Provide a working `docker-compose.yml` and instructions how to get the setup running


## Bonus points

* Provide a way to show container metrics
* Have separate networks with least required access
* Have unlimited FE's and BE's and make LB's autodiscover them


## Outstanding bonus points

* For local development, have syncronized file and directory permissions between container and host os[\[4\]](#4-syncronized-permissions)

---

## Notes

##### \[1\] High-available

Load Balancer's itself are just for demonstration purposes and don't need to be high available or
redundant in your implementation.

##### \[2\] FE

FE refers to the front end and is provided within this repository.

##### \[3\] BE

BE refers to the back end and is provided within this repository.

##### \[4\] Syncronized permissions

When using this setup as a local development stack, you don't want to start it up as root, but
rather as your local user. Additionally you want to have FE and BE data mounted to you host operating
system, so you can edit files with your IDE/editor.

With this in mind, you need to ensure that permissions of files and directories created on your host
machine can still be edited or deleted inside the container by its running service.

Vice-versa saying, any files created within the container should still be editable or deletable on
your host operating system by your local user.
