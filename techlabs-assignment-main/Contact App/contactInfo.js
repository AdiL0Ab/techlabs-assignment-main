class ContactInfo {
    constructor(type, value) {
        this.type = type
        this.value = value
    }

    static addContactInfo(type, value){
        if(typeof type !== 'string'){
            throw new Error("ContactInfo type should be string")
        }

        if(typeof value !== 'number'){
            throw new Error("Contact number should be number")
        }
        if(!Number.isInteger(value)){
            throw new Error("Contact number should be a whole number")
        }

        return new ContactInfo(type, value);
    }

    updateContactInfo(type, value) {
        if(typeof type !== 'string'){
            throw new Error("ContactInfo type should be string")
        }

        if(typeof value !== 'number'){
            throw new Error("Contact number should be number")
        }
        if(!Number.isInteger(value)){
            throw new Error("Contact number should be a whole number")
        }
        
        this.type = type;
        this.value = value;
    }
}

module.exports = ContactInfo