const input = document.getElementById('textInput');
const charCount = document.getElementById('charCount');
const maxLength = 50;

input.addEventListener('input', () => {
  const remaining = maxLength - input.value.length;
    charCount.textContent = remaining + " characters remaining";
  });