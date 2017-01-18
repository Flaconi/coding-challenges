# Senior Full Stack Engineer

Create a simple project to provide a RESTful API to manage categories for an e-commerce website.

The category entity has the following structure:
```javascript
{
        id: <Uuid>,
        name: <String>,
        slug: <String>,
        parentCategory: <Category>,
        isVisible: <Boolean>
}
```

## Required functionality:

* Clients can create a new category.
* Clients can retrieve a category by id or slug.
* Clients can retrieve a tree of children under a specific category.
* Clients can update the visibility status of a specific category.

## Technical constraints:

* You can use any programming language or framework.
* You need to persist the category in a database, you can use any relational or NoSQL database.
* You need to create _unit_ & _integration tests_ for your project, covering at least 70% of your code.
* You need to provide a straight-forward method of running your project.

## Bonus points:

* You will provide a working Dockerfile to run your project and any dependencies, like the database.
* You will use the PATCH HTTP verb to update the visibility status.
* You will create a token-based Authentication & Authorization for the different operations using scopes.
* You will use the Cache headers, including the Etag header.
