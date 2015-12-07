'use strict'
class Note {
    constructor(id, title, content, owner, collaborators, dateCreated, dateModified) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.collaborators = collaborators;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }
}