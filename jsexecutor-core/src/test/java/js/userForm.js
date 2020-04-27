var individualForm1 = function () {

    document.getElementById('name').value="test";
    document.getElementById('surname').value="testsurname";
    document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();
    document.querySelector('#agreement > label').click();

};


var userza = function () {
    document.querySelector('.register-text >a').click();
    document.getElementById('name').click();
    document.getElementById('surname').click();
    document.getElementById('email').click();
    document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();
    document.querySelector('#agreement > label').click();
};

var individualForm = function () {

    document.querySelector('.register-text >a').click();
    document.getElementById('name').click();
    document.getElementById('surname').click();
    document.getElementById('email').click();
    document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();
    document.querySelector('#agreement > label').click();

};

var userForm2 = function () {
    var x = 2;
    document.querySelector('.register-text >a').click();
    document.getElementById('name').click();
    document.getElementById('surname').click();
    document.getElementById('email').click();
    document.querySelector('#registerForm > dl.eula-area > dd:nth-child(1) > label').click();
    document.querySelector('#agreement > label').click();
};

var elements= document.querySelectorAll('.faq-wrapper >ul>li');
elements.forEach(function(item){item.setAttribute('class', 'open')});
