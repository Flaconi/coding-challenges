# DevOps Engineer: Cloudformatoin

Create a parameterized cloudformation template that is capable of provisioning a VPC, IGW,
two public subnets with a NAT gateway each, two private subnets and corresponding routing tables.

Additionally create a second template which will launch a bastion host (EC2 instance) in one of the
public subnets and create and attach a security group to it.


## Required functionality:

* Use Yaml syntax
* CIDR, AZs, tags and bastion host instance type should be parameterized
* Bastion hosts security group should have a parameterized ip range for allowed incoming connections
* It should be possible to create multiple stacks (multiple VPCs, each with a bastion host)


## Technical constraints:

* Provide a working example with instructions how to execute it
* Provide a command/script which will retrieve the IP address of the bastion host


## Bonus points

* Cloudformation template is dynamically generated based on templating languages such as Jinja2
* Number of public and private subnets is automatically equal to number of available AZ's
