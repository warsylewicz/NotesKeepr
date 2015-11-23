'use strict'
class Note {
    constructor(id, title, content, isOwner, collaborators, dateCreated, dateModified) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isOwner = isOwner;
        this.collaborators = collaborators;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }
}