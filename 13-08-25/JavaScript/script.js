document.getElementById('checkLengthBtn').onclick = () => {
  const length = document.getElementById('textInput').value.length;
  document.getElementById('result').textContent = "Length of input: " + length;
};
