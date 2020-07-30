<?php

if (isset($_POST['submit'])) {
  $name = $_POST['name'];
  $emailFrom = $_POST['email'];
  $message = $_POST['message'];

  $emailTo = "jwchungp@gmail.com";
  $headers = "From: ".$emailFrom;
  $email_subject = "Personal Website Submission"
  $email_body = "You have received an e-mail from ".$name.".\n\n".$message;

  mail($emailTo, $email_subject, $email_body, $headers);
  header("Location: success.html");

}

?>