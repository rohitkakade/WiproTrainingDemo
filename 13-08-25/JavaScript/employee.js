var listEmployees = [
  { name: "Sanchit", role: "Manager", empId: 101, salary: 80000 },
  { name: "Unnati", role: "Developer", empId: 102, salary: 60000 },
  { name: "Supriya", role: "QA", empId: 103, salary: 55000 },
  { name: "Amol", role: "Manager", empId: 104, salary: 90000 },
  { name: "Ravi", role: "Manager", empId: 105, salary: 85000 }
];

var totalManagerSalary = listEmployees
  .filter(emp => emp.role === "Manager")
  .reduce((total, emp) => total + emp.salary, 0);

console.log("Total Salary of Managers:", totalManagerSalary);