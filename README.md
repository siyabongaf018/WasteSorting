# Waste Sorting Application

This project is a waste sorting application designed to manage waste categories.

## Table of Contents

- [Overview](#overview)
- [Endpoints](#endpoints)
- [Input Parameters](#input-parameters)
- [Response Formats](#response-formats)
- [Error Handling](#error-handling)



## Overview

The Waste Sorting Application is a RESTful API built with Spring Boot that allows users to perform CRUD operations on waste categories. It includes controllers, services, and repositories to handle HTTP requests, business logic, and database operations, respectively. The application also features global exception handling to provide meaningful error responses.


---
### This API provides endpoints to manage waste categories for sorting purposes.

## Endpoints

[PostMan Documentation link](https://documenter.getpostman.com/view/30306649/2sA3QqesJk)
### Get All Waste Categories

**Endpoint**: `GET /api/waste-categories`

**Description**: Retrieve all waste categories.

### Get Waste Category by ID

**Endpoint**: `GET /api/waste-categories/{id}`

**Description**: Retrieve a waste category by its ID.

### Create Waste Category

**Endpoint**: `POST /api/waste-categories`

**Description**: Create a new waste category.

**Request Body**:
```json
{
    "name": "Metal",
    "description": "Items made from metal materials"
}
```


### Update Waste Category

**Endpoint**: `PUT /api/waste-categories/{id}`

**Description**: Update an existing waste category.

**Request Body**:
```json
{
    "name": "Metal",
    "description": "Items made from metal materials"
}
```


### Delete Waste Category

**Endpoint**: `DELETE /api/waste-categories/{id}`

**Description**: Delete a waste category by its ID.

## Input Parameters

### Create Waste Category

- **name**: The name of the waste category.
- **description**: Description of the waste category.

### Update Waste Category

- **id**: The ID of the waste category to be updated.
- **name**: The new name for the waste category.
- **description**: The new description for the waste category.

### Delete Waste Category

- **id**: The ID of the waste category to be deleted.

## Response Formats

### Get All Waste Categories

**Success Response**:

- **Code**: `200 OK`
- **Content**: List of all waste categories.

### Get Waste Category by ID

**Success Response**:

- **Code**: `200 OK`
- **Content**: The retrieved waste category.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `WasteCategory with id {id} not found`

### Create Waste Category

**Success Response**:

- **Code**: `201 CREATED`
- **Content**: The created waste category.

**Error Response**:

- **Code**: `409 CONFLICT`
- **Content**: `WasteCategory with name {name} already exists`

### Update Waste Category

**Success Response**:

- **Code**: `200 OK`
- **Content**: The updated waste category.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `WasteCategory with id {id} not found`

- **Code**: `409 CONFLICT`
- **Content**: `WasteCategory with name {name} already exists`

### Delete Waste Category

**Success Response**:

- **Code**: `204 NO CONTENT`

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `WasteCategory with id {id} not found`

## Error Handling

### Resource Not Found

If a requested resource (e.g., a waste category) is not found, the API will return a `404 NOT FOUND` status code with an appropriate error message.

### Duplicate Resource

If a duplicate resource is detected (e.g., creating or updating a waste category with an existing name), the API will return a `409 CONFLICT` status code with an appropriate error message.

### General Errors

For unexpected errors, the API will return a generic `500 INTERNAL SERVER ERROR` status code with a detailed error message.
