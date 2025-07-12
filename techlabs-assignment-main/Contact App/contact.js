const ContactInfo = require("./ContactInfo")

class Contact {
    constructor(cName) {
        this.cName = cName
        this.isActive = true
        this.contactInfos = []
    }
    static newContact(cName) {
        //cName check
        if(typeof cName !== 'string'){
            throw new Error("Contact Name should be string")
        }
        return new Contact(cName)
    }

    findContactInfo(type){
        if(typeof type !== 'string'){
            throw new Error("Contact type should be string")
        }
        for(let index = 0; index < this.contactInfos.length; ++index){
            if(this.contactInfos[index].type == type){
                return [true, index]
            }
        }
        return [false, -1];
    }
  
    newContactInfo(type, value){
        if(typeof type !== 'string'){
            throw new Error("ContactInfo type should be string")
        }

        if(typeof value !== 'number'){
            throw new Error("Contact number should be number")
        }
        if(!Number.isInteger(value)){
            throw new Error("Contact number should be a whole number")
        }

        if(!this.isActive){
            throw new Error("contact not found");
        }
        let [isContactInfoExist, indexOfContactInfo] = this.findContactInfo(type);
        if(isContactInfoExist){
            throw new Error("contact type already exists")
        }
        const newContactInfo = ContactInfo.addContactInfo(type, value);
        this.contactInfos.push(newContactInfo)
        return newContactInfo
    }

    updateContactInfo(type, newValue){
        if(typeof type !== 'string'){
            throw new Error("ContactInfo type should be string")
        }

        if(typeof newValue !== 'number'){
            throw new Error("new Contact number should be number")
        }
        if(!Number.isInteger(newValue)){
            throw new Error("new Contact number should be a whole number")
        }

        if(!this.isActive){
            throw new Error("contact not found");
        }
        let [isContactInfoExist, indexOfContactInfo] = this.findContactInfo(type);
        if(!isContactInfoExist){
            throw new Error("contact type not exists")
        }

        this.contactInfos[indexOfContactInfo].updateContactInfo(type, newValue);
    }

    deleteContactInfo(type){
        if(typeof type !== 'string'){
            throw new Error("ContactInfo type should be string")
        }
        
        if(!this.isActive){
            throw new Error("contact not found");
        }
        let [isContactInfoExist, indexOfContactInfo] = this.findContactInfo(type);
        if(!isContactInfoExist){
            throw new Error("contact type not exists")
        }

        this.contactInfos.splice(indexOfContactInfo, 1);
    }

    getAllContactInfo(){
        if(!this.isActive){
            throw new Error("Contact not found");
        }
        return this.contactInfos;
    }
}
module.exports = Contact