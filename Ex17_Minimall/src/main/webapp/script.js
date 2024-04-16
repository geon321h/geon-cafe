/**
 *script.js 
 */
 
let possible = false;
let isCheck = false;
let isBlack = false;
let pwuse = false;
let repwCheck = false;

$(function(){

    $('input[name="id"]').keydown(function(){
        isCheck = false;
        $('#idMessage').empty();
    })
    
});


function duplicate() {
    isCheck = true;
    isBlack = false;
    possible = false;
    
    $.ajax({
        url : "duplicate_Proc.jsp",
        data : ({
            id : $('input[name="id"]').val()
        }),
        success : function(data) {
            if($('input[name="id"]').val()==""){
                $('#idMessage').html("아이디를 입력해주세요.").css('color','red');
                isBlack = true;
            }else if($.trim(data) == "NO"){
                $('#idMessage').html("이미 사용중인 아이디입니다.").css('color','red');
            }else{
                $('#idMessage').html("사용 가능한 아이디입니다.").css('color','green');
                possible = true;
            }
        }
    });

}

function writeSave(){
    if(!isCheck){
        alert("아이디 중복체크를 해주세요.");
        return false;
    }else if(isBlack){
        alert("아이디를 입력해주세요.");
        $('input[name="id"]').focus();
        return false;
    }else if(!possible){
        alert("이미 사용중인 아이디입니다.");
        $('input[name="id"]').focus();
        return false;
    }else if(!pwCheck){
        alert("비밀번호 형식이 올바르지 않습니다.");
        $('input[name="id"]').focus();
        return false;
    }else if(!repwCheck){
        alert("비밀번호가 일치하지않습니다.");
        $('input[name="id"]').focus();
        return false;
    }

}

function pwcheck() {

    var regLength = /.{3,8}/;
    var pw = $('input[name="password"]').val();
    var regexNum = pw.search(/[0-9]/);
    var regexEng = pw.search(/[a-z]/);
    pwCheck = false
    // const reg = /^(?=.*?[0-9])(?=.*?[a-z]).{3,8}$/;
    if(pw ==""){
        alert("비밀번호를 입력해주세요");
        return;
    }
    if(pw.search(regLength) == -1){
        alert("비밀번호를 3~8자리로 입력해주세요.");
        return;
    }
    if(regexEng<0||regexNum<0){
        alert("비밀번호에는 영문자와 숫자를 조합하세요.");
        return;
    }
    $('#pwMessage').empty();
    pwCheck = true;
}

function repasswordCheck() {
    const pw = $('input[name="password"]').val();
    const repw = $('input[name="repassword"]').val();
    if(pw != repw){
        $('input[name="repassword"]').focus();
        $('#pwMessage').html("비밀번호가 일치하지않습니다.").css('color','red');
        repwCheck = false;
        return;
    }else{
        repwCheck = true;
        $('#pwMessage').html("비밀번호가 일치합니다.").css('color','green');
    }
}

function rrnAuto() {
    const rrn = $('input[name="rrn1"]').val().length;
    console.log(rrn);
    if(rrn >= 6){
        $('input[name="rrn2"]').focus();
    }
}