import axios from 'axios'


const signup = async (fullName, email, password) => {
    console.log(fullName)
    console.log(email)
    console.log(password)
    localStorage.setItem('email', email)
    localStorage.setItem('fullName', fullName)
    await axios.post('auth/signup', {
        fullName: `${fullName}`,
        email: `${email}`,
        password: `${password}`
    })
        .then((res) => console.log(res.data))
        .catch((err) => console.error(err));
}

const login = async (email, password, state) => {
    await axios.post('auth/login', {
        email: `${email}`,
        password: `${password}`,
    })
        .then((res) => {
            console.log(res.data)
            localStorage.setItem('token', res.data.token)
            console.log(localStorage.getItem('token'))
            axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
        })
        .catch((err) => console.error(err));
}

const getAll = async (state) => {
    await axios.get('products/getAll', {
        headers: {
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        }
    })
        .then((res) => {
            console.log(res.data)
            state(res.data)
        })
        .catch((err) => console.error(err));
}

const deleteById = async (id, state) => {
    await axios.delete(`products/deleteById/${id}`)
        .then((res) => console.log(res.data))
        .catch((err) => console.error(err));
}

const update = async (id, productName, productColor, productDescription, productPrice, state) => {
    await axios.put(`products/update/${id}`,
        {
            name: `${productName}`,
            color: `${productColor}`,
            description: `${productDescription}`,
            price: `${productPrice}`
        })
        .then((res) => console.log(res.data))
        .catch((err) => console.error(err));
}

const add = async (productName, productColor, productDescription, productPrice, state) => {
    await axios.post('products/add',
        [
            {
                name: `${productName}`,
                color: `${productColor}`,
                description: `${productDescription}`,
                price: `${productPrice}`
            }
        ]
    )
        .then((res) => console.log(res.data))
        .catch((err) => console.error(err));
}

export {
    signup,
    login,
    getAll,
    deleteById,
    update,
    add
}