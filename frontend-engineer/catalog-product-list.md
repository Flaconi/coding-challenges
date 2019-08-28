# Frontend Engineer

Create a simple project to provide a responsive frontend to show a multi-column list of products for an e-commerce website as you can see on https://www.flaconi.de/parfum/.

The product entities have the following structure and will be provided in an array of products:
```javascript
{
        id: <String>,
        name: <String>,
        slug: <String>,
        brand: <String>,
        type: <String>,
        image: <String>,
        price: <Integer>,
        size: <String>,
        rating: <Integer>
}
```

id is the product SKU, image contains a full URL, the price is in cents and the rating with a scale of 0 to 100.

## Required functionality:

* Products data is pulled in from a JSON like [/resources/productlist.json](resources/productlist.json).
* Products are display in a responsive multi-column layout for mobile, tablet & desktop.
* Product images should scale accordingly.
* The list of products is wrapped by some basic layout.
* You will provide some methods to filter the list of products by brand and type.

## Technical constraints:

* You should use  React, Styled components💅, state management is a matter of your choice.
* You need to show some knowledge of HTML5, modern JavaScript(ES6) or TypeScript.
* You will provide a working Dockerfile to run your project

## Bonus points:

* You will provide some methods to sort the list of products.
* You will add some kind of pagination / load more functionality.
* You will write some basic tests for your JavaScript code using Jest.
* You create simple GraphQL server to get the products

## Hints

* Treat this project as if you would continue working on this after your assignment: maintainability, scalability, and readability are super important
* Even though we allow third-party libraries, try to rely as little as possible on tools that write React-, Redux-, CSS-related code for you
* To speed things up, you can use CRA to bootstrap your app.
* If you have any questions feel free to ask us! 

## Hope you enjoy it!
<img src="https://media1.tenor.com/images/170130993a5ce8d03f29415756393597/tenor.gif?itemid=7963714" width="150" height="150" />
