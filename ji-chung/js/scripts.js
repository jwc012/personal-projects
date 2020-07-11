function toggle() {
  let navBarExpanded = document.getElementsByClassName('navbar-toggler')[0].getAttribute('aria-expanded');
  let close_button = document.getElementsByClassName('my-1 mx-2 close')[0];
  let hamburger_button = document.getElementsByClassName('navbar-toggler-icon')[0];
  
  if (navBarExpanded === 'false') {
    hamburger_button.classList.add('d-none');
    close_button.classList.remove('d-none');
  }
  else {
    hamburger_button.classList.remove('d-none');
    close_button.classList.add('d-none');
  }
}