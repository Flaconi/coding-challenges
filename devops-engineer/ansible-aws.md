# DevOps Engineer: Terraform + AWS

Create a Terraform script that is able to peer any number of VPC pairs in AWS in a single
account.


## Required functionality:

* Role must be able to handle an unlimited number of peerings
* Requester VPC id should be looked up by its VPC tags
* Acceptor VPC id should be looked up by its VPC tags
* Ensure that each lookup will only find one unique VPC and abort otherwise
* Role must be idempotent
* Role must have general and sane defaults


## Technical constraints:

* Provide a working example with instructions how to execute it


## Bonus points

* Provide a method to automatically test your role for later CI integration
