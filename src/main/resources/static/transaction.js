let wallets, temp;
// showWallets()
transactionExpenseWalletTitle()
transactionExpenseTagTitle()
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


function transactionExpenseWalletTitle() {

    fetch("/api/wallets", {method: "GET"}).then(response => {
        response.json().then(allWallet => renderSelectList(allWallet))
        const renderSelectList = (allWallet) => {
            let select = $('#walletTitle');
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
            let select2 = $('#tagTitle');
            select2.empty();
            console.log(allTag)
            allTag.forEach(allTag => {
                let temp2 = `<option value="${allTag.titleT}"> ${allTag.titleT}</option>`
                select2.append(temp2)
            })
        }
    })
}


//  function showWallets() {
//
//     fetch("/api/wallets", {method: "GET"}).then(response3 => {
//         response3.json().then(allWallet => renderSelectList(allWallet))
//         const renderSelectList = (allWallet) => {
//             // $("#tbodyID3").empty();
//             allWallet.forEach(allWallet => {
//                document.querySelector("#tbodyID").insertAdjacentHTML('beforeend'
//                    `<tr>
//                 <td>${allWallet.id}</td>
//                 <td>${allWallet.title}</td>
//                 <td>${allWallet.totalAmount}</td>
//
//
//                 </tr>`);
//             })
//         }
//     })
// }

function showWallet() {

    $("#tbodyID").empty();

    wallets.forEach(wallet => {
        console.log(wallet)
console.log(wallet.transaction.blockNote)
        console.log(wallet.tag.titleT)
        $("#tbodyID").append("<tr>" +

            "<td>"+ wallet.transaction.date + "</td>"+
            "<td>" + wallet.title + "</td>" +
            "<td>" + wallet.transaction.type + "</td>" +

            "<td>"+ wallet.tag.titleT +"</td>"+
            "<td>" + wallet.transaction.blockNote + "</td>" +
            "<td>" + wallet.totalAmount + "</td>" +
            "<td>" + wallet.currency + "</td>" +
            "<td><button class='btn btn-info' data-bs-toggle='modal'" +
            " data-bs-target='#Um' onclick='uModal(" + wallet.id + ")'" +
            " style='color: white'>Edit</button></td>" +

            "</tr>");
    });
}

fetch("/api/wallets").then(response => {
    response.json().then(allWal => {
        wallets = allWal;
        showWallet()
    })
})


function addExpense1() {
    let form = $("#newFormExpense");
    $.ajax({
        type: 'POST',
        url: 'api/wallets',
        data: form.serialize(),
        success: function () {
            form.submit()
        }
    })
}

function addExpense2() {
    let form = $("#newFormExpense");

    $.ajax({
        type: 'POST',
        url: 'api/tags',
        data: form.serialize(),
        success: function () {
            form.submit()
        }
    })
}




function addExpense3() {
    let form = $("#newFormExpense");
    $.ajax({

        type: 'POST',
        url: 'api/transaction',
        data: form.serialize(),

        success: function () {
            form.submit()
        }
    })
}
 function addExpense4(){

     let form = {
         type: $("#nav-expense-tab").val().trim()
     }
     $.ajax({

         type: 'POST',
         url: 'api/transaction',
         data: form.serialize(),

         success: function () {
             form.submit()
         }
     })


 }



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

// <script type="text/javascript">
//
//     fetch("/api/wallet"
//     , {
//     method: 'GET'
//     // headers: {'Content-Type': 'application/json'}
// })
//     .then(
//     res => {
//     res.json().then(
//         all => {
//             all.data.forEach((result) => {
//                 document.querySelector('#tbodyID3').insertAdjacentHTML('beforeend',
//                     `<tr>
//            <td>${result.id}</td>
//            <td>${result.identifier}</td>
//            <td>${result.name}</td>
//
//
//            </tr>`);
//             })
//         }
//     )
// }
//     )
// </script>

// function adminTable3() {
//     $("#tbodyID3").empty();
//     users.forEach(user => {
//         $("#tbodyID3" , {method: "GET"}).append("<tr>" +
//             "<td>" + user.id + "</td>" +
//             "<td>" + user.name + "</td>" +
//             "<td>" + user.surname + "</td>" +
//             "<td>" + user.age + "</td>" +
//
//
//             // "<td><button class='btn btn-info' data-bs-toggle='modal' data-bs-target='#Um' onclick='uModal(" + user.id + ")' style='color: white'>Edit</button></td>" +
//             // "<td><button class='btn btn-danger' data-bs-toggle='modal' data-bs-target='#Dm' onclick='dModal(" + user.id + ")' >Delete</button></td>" +
//             "</tr>");
//     });
// }
//
// function adminPage() {
//     fetch("/api/wallet").then(response => {
//         response.json().then(allRoles => {
//             roles = allRoles;
//         })
//     })
//     fetch("/api/admin").then(response => {
//         response.json().then(allUsers => {
//             users = allUsers;
//             adminTable()
//         })
//     })
// }