import React, { useState } from 'react'
import { deleteById } from '../functions/funciones'
import { update } from '../functions/funciones'
import { add } from '../functions/funciones'


function Home() {

  const [productName, setProductName] = useState("")
  const [productColor, setProductColor] = useState("")
  const [productDescription, setProductDescription] = useState("")
  const [productPrice, setProductPrice] = useState(0.0)
  const [productId, setProductId] = useState(0)
  const [error, setError] = useState(false)

  const addProduct = (e) => {
    e.preventDefault()
    if (productName === "" | productColor === "" | productDescription === "" | productPrice === "") {
      setError(true)
      return
    }
    setError(false)
    add(productName, productColor, productDescription, productPrice)
  }

  const deleteProduct = (e) => {
    e.preventDefault()
    if (productId <= 0) {
      setError(true)
      return
    }
    setError(false)
    deleteById(productId)
  }

  const updateProduct = (e) => {
    e.preventDefault()
    if (productId <= 0 | productName === "" | productColor === "" | productDescription === "" | productPrice === "") {
      setError(true)
      return
    }
    setError(false)
    update(productId, productName, productColor, productDescription, productPrice)
  }

  return (
    <div>
      <h1>Welcome {localStorage.getItem('fullName')}</h1>


      <form onSubmit={addProduct}>
        <fieldset>
          <legend>Add Product</legend>
          <input
            type="text"
            placeholder="Product Name"
            value={productName}
            onChange={e => setProductName(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="text"
            placeholder="Product color"
            value={productColor}
            onChange={e => setProductColor(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="text"
            placeholder="Product description"
            value={productDescription}
            onChange={e => setProductDescription(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="number"
            placeholder="Product price"
            value={productPrice}
            onChange={e => setProductPrice(e.target.value)}
            size="30"
          /><br></br>
          <button>Add</button>
          {error && <p>Todos los campos son obligatorios</p>}
        </fieldset>
      </form>

      <form onSubmit={deleteProduct}>
        <fieldset>
          <legend>Delete Product</legend>
          <input
            type="number"
            placeholder="Product Id"
            value={productId}
            onChange={e => setProductId(e.target.value)}
            size="10"
          /><br></br>
          <button>Delete</button>
        </fieldset>
      </form>

      <form onSubmit={updateProduct}>
        <fieldset>
          <legend>Update Product</legend>
          <input
            type="number"
            placeholder="Product Id"
            value={productId}
            onChange={e => setProductId(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="text"
            placeholder="Product Name"
            value={productName}
            onChange={e => setProductName(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="text"
            placeholder="Product color"
            value={productColor}
            onChange={e => setProductColor(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="text"
            placeholder="Product description"
            value={productDescription}
            onChange={e => setProductDescription(e.target.value)}
            size="30"
          /><br></br>
          <input
            type="number"
            placeholder="Product price"
            value={productPrice}
            onChange={e => setProductPrice(e.target.value)}
            size="30"
          /><br></br>
          <button>Update</button>
          {error && <p>Todos los campos son obligatorios</p>}
        </fieldset>
      </form>
    </div>

  )
}

export default Home