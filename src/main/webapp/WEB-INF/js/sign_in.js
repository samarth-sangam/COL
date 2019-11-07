function validate(sign_in_form,uname,pwd1)
{
  var str="";
  var emailReg=/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
  var pwdReg=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
  var email=document.forms[sign_in_form].elements[uname].value;
  var pwd=document.forms[sign_in_form].elements[pwd1].value;
  if(email==""||pwd=="")
  {
    str=str+"field empty";
  }
  if(emailReg.test(email)==false)
  {
    str=str+" email Invalid";
    document.forms[sign_in_form].elements[uname].focus();
    //return false;
  }
  if(pwdReg.test(pwd)==false)
  {
    str=str+" password not strong";
    document.forms[sign_in_form].elements[pwd1].focus();
    //return false;
  }
  if(str!=="")
  {
    alert(str);
    return false;
  }

    return true;


}
