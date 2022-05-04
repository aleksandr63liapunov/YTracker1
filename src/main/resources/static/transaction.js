let wallets;
transactionExpenseWalletTitle()
transactionExpenseTagTitle()
transactionIncomeWalletTitle()
transactionIncomeTagTitle()
// adminTable()
//  $(function () {
//
//     var start = moment().subtract(29, 'days');
//     var end = moment();
//
//     function cb(start, end) {
//         $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
//     }
//
//     $('#reportrange').daterangepicker({
//         startDate: start,
//         endDate: end,
//         ranges: {
//             'Today': [moment(), moment()],
//             'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
//             'Last 7 Days': [moment().subtract(6, 'days'), moment()],
//             'Last 30 Days': [moment().subtract(29, 'days'), moment()],
//             'This Month': [moment().startOf('month'), moment().endOf('month')],
//             'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
//         }
//     }, cb);
//
//     cb(start, end);
//
// });



fetch("/api/transactions/dto_get_all").then(response => {
    response.json().then(allWal => {
        wallets = allWal;
        showWallet()
    })
})

function showWallet() {

    $("#tbodyID").empty();
    wallets.forEach(transaction => {
        console.log(transaction.wallet)
        console.log(transaction.tag)
        $("#tbodyID").append("<tr>" +

            "<td>" + transaction.calendar + "</td>"+
            "<td>" + transaction.wallet.title + "</td>" +
            "<td>" + transaction.type + "</td>" +

            "<td>" + transaction.tag.title+"</td>"+
            "<td>" + transaction.blockNote + "</td>" +
            "<td>" + transaction.wallet.totalAmount + "</td>" +
            "<td>" + transaction.wallet.currency + "</td>" +
            "<td><button class='btn btn-info' data-bs-toggle='modal'" +
            " data-bs-target='#Um' onclick='uModal(" + transaction.id + ")'" +
            " style='color: #f5f3f3'>Edit</button></td>" +

            "</tr>");
    });
}


function transactionExpenseWalletTitle() {

    fetch("/api/wallets", {method: "GET"}).then(response => {
        response.json().then(allWallet => renderSelectList(allWallet))
        const renderSelectList = (allWallet) => {
            let select = $('#walletTitleExpense');
            select.empty();
            console.log(allWallet)
            allWallet.forEach(allWallet => {
                let temp = `<option value="${allWallet.title}"> ${allWallet.title}</option>`
                select.append(temp)
            })
        }
    })
}

function transactionExpenseTagTitle() {

    fetch("/api/tags", {method: "GET"}).then(response2 => {
        response2.json().then(allTag => renderSelectList(allTag))
        const renderSelectList = (allTag) => {
            let select2 = $('#tagTitleExpense');
            select2.empty();
            console.log(allTag)
            allTag.forEach(allTag => {
                let temp2 = `<option value="${allTag.title}"> ${allTag.title}</option>`
                select2.append(temp2)
            })
        }
    })
}

async function addExpense() {
    let form = $("#newFormExpense");

    $.ajax({
        type: 'POST',
        url: '/api/transactions',
        data: form.serialize(),
        success: function () {
            form.submit()
        }
    })
}

function transactionIncomeWalletTitle() {

    fetch("/api/wallets", {method: "GET"}).then(response => {
        response.json().then(allWallet => renderSelectList(allWallet))
        const renderSelectList = (allWallet) => {
            let select = $('#walletTitleIncome');
            select.empty();
            console.log(allWallet)
            allWallet.forEach(allWallet => {
                let temp = `<option value="${allWallet.title}"> ${allWallet.title}</option>`
                select.append(temp)
            })
        }
    })
}

function transactionIncomeTagTitle() {

    fetch("/api/tags", {method: "GET"}).then(response2 => {
        response2.json().then(allTag => renderSelectList(allTag))
        const renderSelectList = (allTag) => {
            let select2 = $('#tagTitleIncome');
            select2.empty();
            console.log(allTag)
            allTag.forEach(allTag => {
                let temp2 = `<option value="${allTag.title}"> ${allTag.title}</option>`
                select2.append(temp2)
            })
        }
    })
}

async function addIncome() {
    let form = $("#newFormIncome");
    $.ajax({
        type: 'POST',
        url: '/api/transactions',
        data: form.serialize(),
        success: function () {
            form.submit()
        }
    })
}








// function getDataFromForm(form) {
//     const data = {
//         blockNote: document.querySelector(`${form} input[name="blockNote"]`).value,
//         //surname: document.querySelector(`${form} input[name="surname"]`).value,
//         //age: document.querySelector(`${form} input[name="age"]`).value,
//
//     }
//
//     const id = document.querySelector(`${form} input[name="id"]`)
//     if (id) data.id = id.value
//
//     return data
// }
//
// async function addExpense3() {
//     try {
//         await request('http://localhost:8080/api/transactions', 'POST',
//             getDataFromForm('#newFormExpense'))
//     } catch (e) {
//         alert('Не удалось создать пользователя')
//         throw e
//     }}
//
// async function request(url, method = 'GET', payload) {
//     const options = {method, headers: {"Content-type": "application/json", "Accept": "application/json"}}
//     if (payload) options.body = JSON.stringify(payload)
//
//     const response = await fetch(url, options)
//
//     if (!response.ok) {
//         alert("Ошибка HTTP: " + response.status)
//         throw Error("Ошибка HTTP: " + response.status)
//     }
//
//     if (method === 'DELETE') return
//
//     return await response.json()
// }




// async function addExpense3(){
//     // let form = $("#newFormExpense");
//         let form = {
//         id: 0,
//         // type: 'EXPENSE',
//         // amountOfCurrency: 500,
//         blockNote: $('#blockNote').val().trim(),
//         date : $('#date').val().trim(),
//         //wallet: null
//             }
//
//     $.ajax({
//         type: 'POST',
//         url: 'api/transactions',
//         data: form.serialize(),
//         success: function () {
//             form.submit()
//         }
//     })
// }


// function addExpense3() {
//     // let form = $("#newFormExpense");
//     let form = {
//         id: 0,
//         type: 'EXPENSE',
//         amountOfCurrency: 500,
//         blockNote: $('#blockNote').val().trim(),
//         date : $('#date1').val().trim(),
//         wallet: null
//     }
//     $.ajax({
//
//         type: 'POST',
//         url: 'api/transactions',
//         data: form.serialize(),
//
//         success: function () {
//             form.submit()
//         }
//     })
// }




// function addExpense3() {
//     let form = $("#newFormExpense");
//     $.ajax({
//         type: 'POST',
//         url: 'api/transaction',
//         data: form.serialize(),
//         success: function () {
//             form.submit()
//         }
//     })
// }
