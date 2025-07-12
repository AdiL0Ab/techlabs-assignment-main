//Driver Code

const User = require("./User");

try {
    const admin1 = User.newAdmin("yash", "yash1234")
    const user1 = admin1.newUser("ritik", "rithik1234")
    const user2 = admin1.newUser("Ravi", "ravi1234")

    admin1.deleteUser("ravi1234");

    const contact1 = user1.newContact("Bishal");
    const contact2 = user1.newContact("Rahul");

    
    user1.updateContact("Bishal","Abhishek");
    // user1.deleteContact("Abhishek");
    
    user1.getContact("Abhishek").newContactInfo("Home", 9991199292);
    user1.getContact("Abhishek").newContactInfo("Personal", 8847562452);
    user1.getContact("Abhishek").updateContactInfo("Home", 9991199265);
    console.log(user1.getContact("Abhishek").getAllContactInfo());
    user1.getContact("Abhishek").deleteContactInfo("Home");
    console.log(user1.getContact("Abhishek").getAllContactInfo());

    console.log(user1.getContact("Rahul").getAllContactInfo());
    // console.log(contact2.newContactInfo("Home", 9991199292));

    // admin1.updateUser("ritik1234", "name", "Ravi")
    // user1.newContact("Vivek")
} catch (error) {
    console.log(error.message)
}

