/*** 레시피 정보 변수 생성 ***/

let menuTitle ;

const koreaFood = [
    {
        name : '국'
    },
    {
        name : '찌개'
    },
    {
        name : '구이'
    }
]
const westernFood = [
    {
        name : '스테이크'
    },
    {
        name : '파스타'
    }
]

let Food;
let FoodList;
let recipe_page_number = 0;
let page = -1;

/*** 페이지 구현 ***/
$(function(){
    switch(document.title){
        case 'recipe_korea' : 
            menuTitle = '한식';
            Food = koreaFood;
            $.ajax({
                url : "./json/koreaFoodList.json",
                dataType : "json",
                success : function(data){
                    FoodList =  data;
                    init();
                }
            });
            break;
        case 'recipe_japan' :
            break;
        case 'recipe_western' :
            menuTitle = '양식';
            Food = westernFood;
            $.ajax({
                url : "./json/westernFoodList.json",
                dataType : "json",
                success : function(data){
                    FoodList =  data;
                    init();
                }
            });
            break;
        default : console.log('잘못된 페이지입니다.');
            break;
    }
    /*for(v in koreaFoodList[0].foodRecipe){
        console.log(koreaFoodList[0].foodRecipe[v]);
    } */

});

function init(){

    $('#menu_title').append(menuTitle) // 메뉴의 타이틀 <h2> 생성
    /* 리스트 생성 */
    for(v in Food){
        let listLine = '<li style="color:Silver;">|</li>'
        if(v == 0){
            $('#menu_food ul').append(`<li><a href="" onclick="return click_menu(-1)">전체</a></li>`);
        }
        $('#menu_food ul').append(`${listLine}<li><a href="" onclick="return click_menu('${v}')">${Food[v].name}</a></li>`);
        
        if((v+1)%3 == 0){
            $('#menu_food ul').append('<br>');
        }

        $('#menu_food ul a:first').css('color','black'); // 기본 전체
    }

    /* 음식 나열 */
    for(v in FoodList){
        $('#food_area').append(
            `<div class="food_preview_area"  onclick='click_food(${v})'">
                <div class="food_preview_img_area">
                    <img class="food_preview_img" src="${FoodList[v].foodImg[0]}">
                </div>
                <span>${FoodList[v].foodName}</span>
            </div>`
        )
    }
}

function click_menu(num){
    

    let menu_num = parseInt(num) +1;
    $(`#menu_food ul a`).css('color','#898989');
    $(`#menu_food ul a:eq(${menu_num})`).css('color','black');
    if(num == -1){
        $('#food_area').empty();
        for(v in FoodList){
            $('#food_area').append(
                `<div class="food_preview_area"  onclick='click_food(${v})'">
                    <div class="food_preview_img_area">
                        <img class="food_preview_img" src="${FoodList[v].foodImg[0]} ">
                    </div>
                    <span>${FoodList[v].foodName}</span>
                </div>`
            )
        }
        return false;
    }
    
    $('#food_area').empty();
    for(v in FoodList){
        if(FoodList[v].foodTitle == Food[num].name){
            $('#food_area').append(
                `<div class="food_preview_area"  onclick='click_food(${v})'">
                    <div class="food_preview_img_area">
                        <img class="food_preview_img" src="${FoodList[v].foodImg[0]}">
                    </div>
                    <span>${FoodList[v].foodName}</span>
                </div>`
            )
        }
    }

    return false;

}

function click_food(num){

    // 레시피 위치로 이동 //
    let sectionTop = document.getElementById('recipe_area').offsetTop - 160;
    window.scroll({ top: sectionTop,behavior:'smooth' });


    // 이미지 생성 //
    $('#recipe_img_sub').empty();
    
    for(v in FoodList[num].foodImg){
        $('#recipe_img_sub').append(
            `<img class="recipe_img_sub" src="${FoodList[num].foodImg[v]}" onclick='click_recipe_img(${num},${v})'></img>`
        );
    }

    click_recipe_img(num,0);

    // 텍스트 생성 //
    $('#recipe_text_area h3').html(FoodList[num].foodName);
    $('#recipe_explanation_area').empty();
    $('#recipe_explanation_area').append(`<img id="left_btn" src="image/icon/left_arrow_icon.png" onclick="click_arrow('left')"></img>`);
    $('#recipe_explanation_area').append('<div id="recipe_explanation_frame"><div id="recipe_explanation"></div></div>');
    $('#recipe_explanation_area').append(`<img id="right_btn" src="image/icon/right_arrow_icon.png" onclick="click_arrow('right')"></img>`);

    page = 1; // 페이지 초기화
    recipe_page_number = FoodList[num].foodRecipe.length; // 페이지 최대치 설정
    for(v in FoodList[num].foodRecipe){
        if(v == 0){
            $('#recipe_explanation_frame #recipe_explanation')
                .append(`<div id="recipe_first"><p>${parseInt(v)+1}. ${FoodList[num].foodRecipe[v]}</p></div>`);
        }else{
            $('#recipe_explanation_frame #recipe_explanation')
                .append(`<div><p>${parseInt(v)+1}. ${FoodList[num].foodRecipe[v]}</p></div>`);
        }
    }

    
}

function click_recipe_img(num,imgNum){
    $('#recipe_img_main').html(
        `<img class="recipe_img_main" src="${FoodList[num].foodImg[imgNum]}"></img>`
    );
    $(`.recipe_img_main`).fadeToggle();
    $(`.recipe_img_sub`).css('border','1px solid white').fadeTo('fast',1);
    $(`.recipe_img_sub:eq(${imgNum})`).css('border','1px solid #EEE8AA').fadeTo('fast',0.3);

}

function click_arrow(way){

    if(way == "left"){
        if(page == 1){
            console.log('첫번째');
            return;
        }else if(page == 2){
            $('#left_btn').css('filter','opacity(0.3) drop-shadow(0 0 0 #ededed)')
        }else{
            $('#right_btn').css('filter','opacity(1) drop-shadow(0 0 0 #000000)')
        }
        $('#recipe_first').animate({marginLeft:'+=600px'},1000);
        page--;
    }else{
        if(page == recipe_page_number){
            console.log('마지막');
            return;
        }else if(page == recipe_page_number-1){
            $('#right_btn').css('filter','opacity(0.3) drop-shadow(0 0 0 #ededed)')
        }else(
            $('#left_btn').css('filter','opacity(1) drop-shadow(0 0 0 #000000)')
        )
        $('#recipe_first').animate({marginLeft:'-=600px'},1000);
        page++;
    }

}

