async function logProducts() {
  const response = await fetch("/api/products");
  const products = await response.json();
  console.log(products);
}

const hello = ()=> alert("hello world");
hello();
logProducts();
