var a = 10;        
let b = 20;        
const c = 30;      

function testScopes() {
  var a = 40;      
  let b = 50;      
  const c = 60;    

  if (true) {
    var a = 70;    
    let b = 80;    
    const c = 90; 

    console.log("Inside if block:");
    console.log("a =", a);  
    console.log("b =", b);  
    console.log("c =", c);  
  }

  console.log("Inside function after if:");
  console.log("a =", a); 
  console.log("b =", b);  
  console.log("c =", c);  
}

testScopes();

console.log("In global scope:");
console.log("a =", a);  
console.log("b =", b); 
console.log("c =", c);  