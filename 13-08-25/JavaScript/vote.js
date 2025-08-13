let persons = [
  { name: "Unnati", age: 24, city: "Pune" },
  { name: "Sanchit", age: 23, city: "Mumbai" },
  { name: "Utkarsh", age: 17, city: "Delhi" },
  { name: "Shivani", age: 16, city: "Bangalore" }
];
// for (let i = 0; i < persons.length; i++) {
//   if (persons[i].age >= 18) {
//     persons[i].status = "Adult";
//   } else {
//     persons[i].status = "Minor";
//   }
 persons.map(i => {
  if (i.age >= 18) {
    i.status = "Adult";
  } else {
    i.status = "Minor";
  }
  return i;
});

console.log(persons);