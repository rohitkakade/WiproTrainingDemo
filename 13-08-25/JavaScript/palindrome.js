function isPalindrome(str) {
  str = str.toLowerCase();
  let reversed = '';
  for (let i = str.length - 1; i >= 0; i--) {
    reversed += str[i];
  }
  return str === reversed;
}

function checkPalindrome() {
  let str = document.getElementById("textInput").value;
  if (isPalindrome(str)) {
    console.log(`"${str}" is a palindrome.`);
  } else {
      console.log(`"${str}" is not a palindrome.`);
    }
  }