function onChange() {
  const password = document.querySelector('input[name=pass]');
  const confirm = document.querySelector('input[name=confPass]');
  if (confirm.value === password.value) {
    confirm.setCustomValidity('');
  } else {
    confirm.setCustomValidity('As senhas não conferem!');
  }
}