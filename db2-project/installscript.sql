CREATE TABLE Users (
    UserID NUMBER PRIMARY KEY,
    Username VARCHAR2(255) NOT NULL,
    Email VARCHAR2(255) NOT NULL,
    Password VARCHAR2(255) NOT NULL
);

CREATE TABLE Streamer (
    StreamerID NUMBER PRIMARY KEY,
    UserID NUMBER REFERENCES Users(UserID)
);

CREATE TABLE Viewer (
    ViewerID NUMBER PRIMARY KEY,
    UserID NUMBER REFERENCES Users(UserID)
);

CREATE TABLE Subscriptions (
    ViewerID NUMBER REFERENCES Viewer(ViewerID),
    StreamerID NUMBER REFERENCES Streamer(StreamerID),
    CONSTRAINT pk_Subscriptions PRIMARY KEY (ViewerID, StreamerID)
);

CREATE TABLE Tags (
    TagsID NUMBER PRIMARY KEY,
    Title VARCHAR2(255) NOT NULL
);

CREATE TABLE Stream (
    StreamID NUMBER PRIMARY KEY,
    StreamerID NUMBER REFERENCES Streamer(StreamerID),
    TagsID NUMBER REFERENCES Tags(TagsID),
    StartTime TIMESTAMP,
    EndTime TIMESTAMP,
    ViewerCount NUMBER,
    ChatID NUMBER
);

CREATE TABLE Chat (
    ChatID NUMBER PRIMARY KEY,
    StreamID NUMBER REFERENCES Stream(StreamID)
);

CREATE TABLE Message (
    MessageID NUMBER PRIMARY KEY,
    ViewerID NUMBER REFERENCES Viewer(ViewerID),
    ChatID NUMBER REFERENCES Chat(ChatID),
    Timestamp TIMESTAMP,
    Content VARCHAR2(4000)  -- Oracle unterstützt bis zu 4000 Byte für VARCHAR2
);

CREATE TABLE StreamViewer (
    StreamID NUMBER REFERENCES Stream(StreamID),
    ViewerID NUMBER REFERENCES Viewer(ViewerID),
    CONSTRAINT pk_StreamViewer PRIMARY KEY (StreamID, ViewerID)
);
