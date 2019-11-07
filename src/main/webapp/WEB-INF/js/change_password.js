function validate(change_password_form,curr_password,new_password,verify_password)
{
  var str="";
  var pwdReg=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;

  var curr_pwd=document.forms[change_password_form].elements[curr_password].value;
  var new_pwd=document.forms[change_password_form].elements[new_password].value;
  var verify_pwd=document.forms[change_password_form].elements[verify_password].value;
  if(curr_pwd==""||new_pwd==""||verify_pwd=="")
  {
    str=str+"field empty";
  }
  if(new_pwd!==verify_pwd)
  {
    str=str+"new pass doesnt match verify pass";
  }
  if(new_pwd==curr_pwd)
  {
    str=str+"password same as current password";
  }

  if(pwdReg.test(verify_pwd)==false)
  {
    str=str+" password not strong";
    document.forms[change_password_form].elements[verify_password].focus();
    document.forms[change_password_form].elements[new_password].focus();
    //return false;
  }
  if(str!=="")
  {
    alert(str);
    return false;
  }

    return true;


}
