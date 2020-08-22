// A method to show the hamburger or close icon
function toggle() {
  //  document.getElementsByClassName returns a list of elements with the className
  // Getting the attribute that will tell me if the navbar hamburger is collapsed or not
  let navBarExpanded = document.getElementsByClassName('navbar-toggler')[0].getAttribute('aria-expanded');
  // Getting the X text/html code
  let closeButton = document.getElementsByClassName('my-1 mx-2 close')[0];
  // Getting the hamburger icon
  let hamburgerButton = document.getElementsByClassName('navbar-toggler-icon')[0];

  // If the nav-bar is not collapsed. The links are displayed
  if (navBarExpanded === 'false') {
    //  Add the text into the hamburger icon, which will hide the html code, using bootstrap code
    hamburgerButton.classList.add('d-none');
    // Display the close button text/icon by removing the d-none text
    closeButton.classList.remove('d-none');
  }
  else {
    // Display the hamburger icon
    hamburgerButton.classList.remove('d-none');
    //  Add the text into the close_button html code, which will hide the html code, using bootstrap code
    closeButton.classList.add('d-none');
  }
}

function submitToAPI(e) {
  e.preventDefault();

  var name = document.getElementById('name').value;
  var email = document.getElementById('email').value;
  var message = document.getElementById('message').value;

  if (name == "" || email == "" || message == "") {
    alert("Please Fill Out All Required Fields");
    return false;
  }

  var data = {
    name: name,
    email: email,
    message: message
  };

  $.ajax({
    type: 'POST',
    url: 'https://yoz5hz8sd4.execute-api.us-west-2.amazonaws.com/prod/contact-form-submit',
    dataType: 'json',
    crossDomain: 'true',
    contentType: 'application/json; charset=utf-8',
    data: JSON.stringify(data),

    success: function () {
      window.location = 'success.html';
      // clear form and show a success message
      document.getElementById('contact-form').reset();
    },
    error: function () {
      // show an error message
      alert('UnSuccessful');
    }
  });
}