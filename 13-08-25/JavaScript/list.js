
const names = ["Alice", "Jonathan", "Sam", "Michael", "Bob", "Christina", "Eve"];


const longNames = names.filter(name => name.length > 5);
 const upperCaseNames = longNames.map(name => name.toUpperCase());


document.getElementById("output").textContent = upperCaseNames.join(", ");

console.log("Original Names:", names);
console.log("Filtered & Uppercase:", upperCaseNames);
