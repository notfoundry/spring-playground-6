function onCreateAddressBook(response) {
    const addressbookId = response._links.self.href.substr(response._links.self.href.lastIndexOf("/") + 1);
    const html = `
                <div>
                    <h3>Addressbook ${addressbookId}<h3/>
                    <table id="addressbook-${addressbookId}">
                        <thead>
                        <tr>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Address</td>
                            <td>Telephone</td>
                        </tr>
                        </thead>
                        <tbody id="addressbook-${addressbookId}-data">
                        </tbody>
                    </table>
                    <form id="button-buddy-create-${addressbookId}" addressbook-id="${addressbookId}" method="post" action="/editor/addressbook/${addressbookId}/buddyinfo">
                        <label for="firstName">First Name:</label><br>
                        <input type="text" id="firstName" name="firstName"><br>

                        <label for="lastName">Last Name:</label><br>
                        <input type="text" id="lastName" name="lastName"><br>

                        <label for="address">Address:</label><br>
                        <input type="text" id="address" name="address"><br>

                        <label for="telephoneNum">Telephone:</label><br>
                        <input type="text" id="telephoneNum" name="telephoneNum">

                        <input type="submit" value="Add Buddy">
                    </form>
                    <hr>
                <div/>
                `
    $("#addressbooks").append(html);
    
    $(`#button-buddy-create-${addressbookId}`).submit(function(e){
        e.preventDefault()

        const form = $(this);
        const formData = form.serializeArray().reduce(function(obj, item) {
            obj[item.name] = item.value;
            return obj;
        }, {})
        $.ajax({
            url: `/editor/addressbook/${addressbookId}/buddyinfo`,
            type: 'post',
            data: form.serialize(),
        });
        const html = `
                    <tr>
                        <td>${formData.firstName}<td/>
                        <td>${formData.lastName}<td/>
                        <td>${formData.address}<td/>
                        <td>${formData.telephoneNum}<td/>
                    </tr>
                `;
        $(`#addressbook-${addressbookId}-data`).append(html)
        return false;
    });
}

$(function() {
    $("#button-create-addressbook").submit(function(e){
        e.preventDefault()

        const form = $(this);
        $.ajax({
            url: '/api/addressbook',
            type: 'post',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({buddies: []}),
            success: onCreateAddressBook
        });
        return false;
    });
});

