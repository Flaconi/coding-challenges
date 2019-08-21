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

## Technical constraints:

* You can use any programming language, tools and frameworks you see fit, preferably React, Redux, Styled components💅. 
* You need to show some knowledge of HTML5, modern JavaScript(ES6).
* You need to provide a straight-forward method of running your project.

## Bonus points:

* You will provide some methods to sort / filter the list of products.
* You will add some kind of pagination / load more functionality.
* You will provide optimized and minimized version of scripts and styles.
* You will write some basic tests for your JavaScript code.
