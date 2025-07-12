const Contact = require("./Contact")

class User {
    static allUser = []
    constructor(name, username, isAdmin) {
        this.name = name
        this.username = username
        this.isAdmin = isAdmin
        this.isActive = true
        this.contacts = []
    }
    static findUser(username) {
        //type validation
        if(typeof username !== 'string'){
            throw new Error("Username should be string")
        }
        for (let index = 0; index < User.allUser.length; index++) {
            if (User.allUser[index].username == username && User.allUser[index].isActive) {
                return [true, index]
            }
        }
        return [false, -1]
    }

    findContact(cName) {
         //type validation
         if(typeof cName !== 'string'){
            throw new Error("Contact Name should be string")
        }
        for (let index = 0; index < this.contacts.length; index++) {
            if (this.contacts[index].cName == cName && this.contacts[index].isActive) {
                return [true, index]
            }
        }
        return [false, -1]

    }


    newContact(cName) {
        //check cname is string
        if(typeof cName !== 'string'){
            throw new Error("Contact Name should be string")
        }
        //check not admin
        if(!this.isActive){
            throw new Error("User not found")
        }
        if (this.isAdmin){
            throw new Error("Admin Cannot Create Contacts")
        }
        
        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (isContactExist) {
            throw new Error("Contact Already Exist")
        }

        const newContact = Contact.newContact(cName)
        this.contacts.push(newContact)
        return newContact
    }

    getContact(cName){
       //check cname is string
        if(typeof cName !== 'string'){
            throw new Error("Contact Name should be string")
        }
        if(!this.isActive){
            throw new Error("User not found")
        }
        if (this.isAdmin){
            throw new Error("Admin don't have access to Contacts")
        }

        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact not found")
        }
        return this.contacts[indexOfContact];
    }

    updateContact(cName, newName) {
        //check cname is string
        if(typeof cName !== 'string'){
            throw new Error("Contact Name should be string")
        }

        //check newName is string
        if(typeof newName !== 'string'){
            throw new Error("New contact Name should be string")
        }

        if(!this.isActive){
            throw new Error("User not found")
        }
        if (this.isAdmin){
            throw new Error("Admin Cannot delete Contacts")
        }
        
        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact not found")
        }

        this.contacts[indexOfContact].cName = newName;
    }

    deleteContact(cName) {
        //check cname is string
        if(typeof cName !== 'string'){
            throw new Error("Contact Name should be string")
        }
        
        //check not admin
        if(!this.isActive){
            throw new Error("User not found")
        }
        if (this.isAdmin){
            throw new Error("Admin Cannot delete Contacts")
        }
        
        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact not found")
        }

        this.contacts[indexOfContact].isActive = false;
        this.contacts.splice(indexOfContact, 1);
    }

   

    static newAdmin(name, username) {
        //check name is string
        if(typeof name !== 'string'){
            throw new Error("Admin name should be string")
        }

        //check username is string
        if(typeof username !== 'string'){
            throw new Error("username should be string")
        }


        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (isUserExist) {
            throw new Error("Username Already Exist")
        }
        const admin = new User(name, username, true)
        User.allUser.push(admin)
        return admin
    }
    newUser(name, username) {
        //check name is string
        if(typeof name !== 'string'){
            throw new Error("User name should be string")
        }

        //check username is string
        if(typeof username !== 'string'){
            throw new Error("username should be string")
        }
        //check
        if(!this.isActive){
            throw new Error("User not found")
        }
        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (isUserExist) {
            throw new Error("Username Already Exist")
        }
        const user = new User(name, username, false)
        User.allUser.push(user)
        return user
    }
    getAllUser() {
        //check
        if(!this.isActive){
            throw new Error("User not found")
        }
        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        return User.allUser
    }

    updateUser(username, parameter, newValue) {
        //type validation - name -username
        if(typeof username !== 'string'){
            throw new Error("username should be string")
        }
        if(typeof parameter !== 'string'){
            throw new Error("parameter should be string")
        }
        if(typeof newValue !== 'string'){
            throw new Error("newValue should be string")
        }
        //check
        if(!this.isActive){
            throw new Error("User not found")
        }
        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (!isUserExist) {
            throw new Error("Username Does not Exist")
        }
        switch (parameter) {
            case "name": User.allUser[indexOfUserFound].updateName(newValue)
                break;
            case "username": User.allUser[indexOfUserFound].updateUsername(newValue)
                break;
            default:
                throw new Error("Invalid Parameter")

        }
    }
    updateName(newName) {
        //newName string check
        if(typeof newValue !== 'string'){
            throw new Error("newValue should be string")
        }

        if(!this.isActive){
            throw new Error("User not found")
        }
        this.name = newName
    }
    updateUsername(newUsername) {
        if(typeof newUsername !== 'string'){
            throw new Error("new user name should be string")
        }

        if(!this.isActive){
            throw new Error("User not found")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(newUsername)
        if (isUserExist) {
            throw new Error("Username Already Exists")
        }
        this.username = newUsername
    }
    deleteUser(username) {
        if(typeof username !== 'string'){
            throw new Error("user name should be string")
        }

        if(!this.isActive){
            throw new Error("User not found")
        }
        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (!isUserExist) {
            throw new Error("Username Does not Exist")
        }

        User.allUser[indexOfUserFound].isActive = false;
        User.allUser.splice(indexOfUserFound, 1);
    }



}

module.exports = User