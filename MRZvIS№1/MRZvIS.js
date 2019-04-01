/////////////////////////////////////////////////////////////////////////////////////////
// Лабораторная работа №1 по дисциплине МРЗвИС
// Выполнена студентом группы 721702
// БГУИР Каленик Павел Романович
//
// Вариант 14: Алгоритм вычисления произведения пары 8-разрядных чисел 
// умножением с младших разрядов со сдвигом частичной суммы вправо
//
// 20.03.2019
//
// Функция sumNumbers взята из ресурса: https://ru.stackoverflow.com/questions/642469/Сложение-двух-двоичных-чисел 
// Основные методы для создания таблицы взяты из ресурса: http://www.w3schools.com/js/

var carry = 0;
function sumNumbers(firstNumber, secondNumber){
    var result = "";
    var firstBit;
    var secondBit;
    var sum;

    for (var i = 16; i >= 0; --i) {
        firstBit = firstNumber[i];
        secondBit = secondNumber[i];
        sum = (firstBit ^ secondBit ^ carry);
        result = sum + result;
        carry = (firstBit & carry) | (secondBit & carry) | (firstBit & secondBit);
    }
    if (carry) result = '1' + result;

    result = result.slice(0, result.length - 1);
    return result;
}

function multNumbers(firstNumber, secondNumber){
    var resultVector = [];
    var partialSum = "";
    for (var i = 0; i < 16; ++i) partialSum = partialSum + '0';
    for (var i = 8; i < 16; ++i) firstNumber = firstNumber + '0';
    for (var i = 7; i >= 0; --i) {
        if (secondNumber[i] == '1'){
            partialSum = sumNumbers(partialSum, firstNumber);
            partialSum = partialSum.slice(0, -1);
            partialSum = '0' + partialSum;
            if (partialSum.length == 17 & partialSum[0] == '0'){
               partialSum = partialSum.slice(1, partialSum.length);
            }
        } else {
            partialSum = partialSum.slice(0, -1);
            if (carry == 1){
                partialSum = '1' + partialSum;
            } else {
                partialSum = '0' + partialSum;
            }   
        }
        resultVector.push(partialSum);
    }
    return resultVector;
}

function main(){
    var firvec = document.getElementById("firvec");
    var secvec = document.getElementById("secvec");
    var firstVectorString = firvec.value;
    var secondVectorString = secvec.value;
    var firstVector = firstVectorString.split(' ');
    var secondVector = secondVectorString.split(' ');
    var translationTable = document.getElementById("firsttable");
    var table = document.getElementById("secondtable");
    var pipelineVector = [];

    translationTable.insertRow(0);
    translationTable.insertRow(1);
    translationTable.rows[0].insertCell(0);
    translationTable.rows[0].cells[0].innerText = "Translation of the first vector:";
    translationTable.rows[1].insertCell(0);
    translationTable.rows[1].cells[0].innerText = "Translation of the second vector:";
    var thV = [];
    for (i = 0; i < firstVector.length; ++i){
        thV.push(+firstVector[i] * +secondVector[i]);
    }

    for (var i = 0; i < firstVector.length; ++i) {
        firstVector[i] = +firstVector[i];
        translationTable.rows[0].insertCell(-1);
        translationTable.rows[0].cells[i + 1].innerText = firstVector[i] + " = ";
        firstVector[i] = firstVector[i].toString(2);
        translationTable.rows[0].cells[i + 1].innerText += " " + firstVector[i].slice(0, 4) + " " + firstVector[i].slice(4, 8);
    }

    for (var i = 0; i < secondVector.length; ++i) {
        secondVector[i] = +secondVector[i];
        translationTable.rows[1].insertCell(-1);
        translationTable.rows[1].cells[i + 1].innerText = secondVector[i] + " =";
        secondVector[i] = secondVector[i].toString(2);
        translationTable.rows[1].cells[i + 1].innerText += " " + secondVector[i].slice(0, 4) + " " + secondVector[i].slice(4, 8);
    }

    for (var i = 0; i < firstVector.length; ++i){
        if (firstVector[i] > secondVector[i]){
            var tmp = firstVector[i];
            firstVector[i] = secondVector[i];
            secondVector[i] = tmp;
        }
        pipelineVector.push(multNumbers(firstVector[i], secondVector[i]));
        carry = 0;
    } 

    table.insertRow(-1);
    table.rows[0].insertCell(-1);
    table.rows[0].cells[0].innerText = "Pairs";
    
    for (var i = 0; i < 8; i++) {
        table.rows[0].insertCell(-1);
        table.rows[0].cells[i + 1].innerText = "Stage:" + (i + 1);
    }

    table.rows[0].insertCell(-1);
    table.rows[0].cells[9].innerText = "Results";
    
    for (var i = 1; i < 8 + firstVector.length; i++) {
        table.insertRow(-1);
        for (var j = 0; j < 10; j++) {
            table.rows[i].insertCell(-1);
        }
    }
    
    for (var i = 0; i < firstVector.length; i++) { 
        table.rows[i + 1].cells[0].innerText = firstVector[i].slice(0, 4) + " " + firstVector[i].slice(4, 8) + "\n" + secondVector[i].slice(0, 4) + " " + secondVector[i].slice(4, 8);
    }
    
    for (var j = 0; j < firstVector.length; j++) { 
       for (var i = 0; i < 8; i++) {
            table.rows[i + j + 1].cells[i + 1].innerText = "Tact:" + (j + 1 + i) + " \n" + pipelineVector[j][i].slice(0, 4) + " " + pipelineVector[j][i].slice(4, 8)+ " " + pipelineVector[j][i].slice(8, 12)+ " " + pipelineVector[j][i].slice(12, 16);
            if (i == 7){
                if ( thV[j] != parseInt(pipelineVector[j][7], 2)) table.rows[i + j + 1].cells[9].innerText = thV[j];
                else table.rows[i + j + 1].cells[9].innerText = parseInt(pipelineVector[j][7], 2);
            }
        }
    }   
}