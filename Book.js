import React from 'react'

const Book = ({img, title,author}) =>{
    
    const clickHandler = () =>{
        alert("Hello world!");
    };
    const complexExample = (author) =>{
       console.log(author);
    }
    return (
    <article className="book">
       <img src={img}></img>
       <h1>{title}</h1>
       <h4>{author}</h4>
       <button onClick={clickHandler}>Example</button>
       <button onClick={()=>complexExample(author)}>Complex Example</button>
    </article>);
}

export default Book
