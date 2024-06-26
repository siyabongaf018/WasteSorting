# Waste Sorting Application

This project is a waste sorting application designed to manage waste categories.

## Table of Contents

- [Overview](#overview)
- [Endpoints](#endpoints)
- [Input Parameters](#input-parameters)
- [Response Formats](#response-formats)
- [Error Handling](#error-handling)

## Overview

The Waste Sorting Application is a RESTful API built with Spring Boot that allows users to perform CRUD operations on waste categories, disposal guidelines, and recycling tips. It includes controllers, services, and repositories to handle HTTP requests, business logic, and database operations, respectively. The application also features global exception handling to provide meaningful error responses.

### This API provides endpoints to manage waste categories for sorting purposes.

## Endpoints

[PostMan Documentation link](https://documenter.getpostman.com/view/30306649/2sA3QqesJk)

### Waste Categories

#### Get All Waste Categories

**Endpoint**: `GET /api/waste-categories`

**Description**: Retrieve all waste categories.

#### Get Waste Category by ID

**Endpoint**: `GET /api/waste-categories/{id}`

**Description**: Retrieve a waste category by its ID.

#### Create Waste Category

**Endpoint**: `POST /api/waste-categories`

**Description**: Create a new waste category.

**Request Body**:
```json
{
  "name": "Metal", 
  "description": "Items made from metal materials"
}
```

#### Update Waste Category

**Endpoint**: `PUT /api/waste-categories/{id}`

**Description**: Update an existing waste category.

**Request Body**:
```json
{
  "name": "Metal",
  "description": "Items made from metal materials"
}
```

#### Delete Waste Category

**Endpoint**: `DELETE /api/waste-categories/{id}`

**Description**: Delete a waste category by its ID.

### Disposal Guidelines

#### Get All Disposal Guidelines

**Endpoint**: `GET /api/disposal-guidelines`

**Description**: Retrieve all disposal guidelines.

#### Get Disposal Guideline by ID

**Endpoint**: `GET /api/disposal-guidelines/{id}`

**Description**: Retrieve a disposal guideline by its ID.

#### Create Disposal Guideline

**Endpoint**: `POST /api/disposal-guidelines`

**Description**: Create a new disposal guideline.

**Request Body**:
```json
{
"guideline": "Do not mix with wet waste",
"wasteCategoryId": 1
}
```

#### Update Disposal Guideline

**Endpoint**: `PUT /api/disposal-guidelines/{id}`

**Description**: Update an existing disposal guideline.

**Request Body**:
```json
{
"guideline": "Do not mix with wet waste",
"wasteCategoryId": 1
}
```

#### Delete Disposal Guideline

**Endpoint**: `DELETE /api/disposal-guidelines/{id}`

**Description**: Delete a disposal guideline by its ID.

### Recycling Tips

#### Get All Recycling Tips

**Endpoint**: `GET /api/recycling-tips`

**Description**: Retrieve all recycling tips.

#### Get Recycling Tip by ID

**Endpoint**: `GET /api/recycling-tips/{id}`

**Description**: Retrieve a recycling tip by its ID.

#### Create Recycling Tip

**Endpoint**: `POST /api/recycling-tips`

**Description**: Create a new recycling tip.

**Request Body**:
```
{
"tip": "Recycle metal at a local center",
"wasteCategoryId": 1
}
```

#### Update Recycling Tip

**Endpoint**: `PUT /api/recycling-tips/{id}`

**Description**: Update an existing recycling tip.

**Request Body**:
```json
{
"tip": "Recycle metal at a local center",
"wasteCategoryId": 1
}
```

#### Delete Recycling Tip

**Endpoint**: `DELETE /api/recycling-tips/{id}`

**Description**: Delete a recycling tip by its ID.

## Input Parameters

### Create Waste Category

- **name**: The name of the waste category.
- **disposalGuidelines**: A list of disposal guidelines associated with the waste category.
- **recyclingTips**: A list of recycling tips associated with the waste category.

### Update Waste Category

- **id**: The ID of the waste category to be updated.
- **name**: The new name for the waste category.
- **disposalGuidelines**: Updated list of disposal guidelines.
- **recyclingTips**: Updated list of recycling tips.

### Delete Waste Category

- **id**: The ID of the waste category to be deleted.

### Create Disposal Guideline

- **guideline**: The disposal guideline description.
- **wasteCategoryId**: The ID of the associated waste category.

### Update Disposal Guideline

- **id**: The ID of the disposal guideline to be updated.
- **guideline**: The updated disposal guideline description.
- **wasteCategoryId**: The ID of the associated waste category.

### Delete Disposal Guideline

- **id**: The ID of the disposal guideline to be deleted.

### Create Recycling Tip

- **tip**: The recycling tip description.
- **wasteCategoryId**: The ID of the associated waste category.

### Update Recycling Tip

- **id**: The ID of the recycling tip to be updated.
- **tip**: The updated recycling tip description.
- **wasteCategoryId**: The ID of the associated waste category.

### Delete Recycling Tip

- **id**: The ID of the recycling tip to be deleted.

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

### Get All Disposal Guidelines

**Success Response**:

- **Code**: `200 OK`
- **Content**: List of all disposal guidelines.

### Get Disposal Guideline by ID

**Success Response**:

- **Code**: `200 OK`
- **Content**: The retrieved disposal guideline.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `DisposalGuideline with id {id} not found`

### Create Disposal Guideline

**Success Response**:

- **Code**: `201 CREATED`
- **Content**: The created disposal guideline.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `WasteCategory with id {wasteCategoryId} not found`

### Update Disposal Guideline

**Success Response**:

- **Code**: `200 OK`
- **Content**: The updated disposal guideline.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `DisposalGuideline with id {id} not found`

### Delete Disposal Guideline

**Success Response**:

- **Code**: `204 NO CONTENT`

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `DisposalGuideline with id {id} not found`

### Get All Disposal Guideline By Category Id

**Success Response**:

- **Code**: `200 OK`
- **Content**: `All DisposalGuideline with connect to that category`


### Get All Recycling Tips

**Success Response**:

- **Code**: `200 OK`
- **Content**: List of all recycling tips.

### Get Recycling Tip by ID

**Success Response**:

- **Code**: `200 OK`
- **Content**: The retrieved recycling tip.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `RecyclingTip with id {id} not found`

### Create Recycling Tip

**Success Response**:

- **Code**: `201 CREATED`
- **Content**: The created recycling tip.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `WasteCategory with id {wasteCategoryId} not found`

### Update Recycling Tip

**Success Response**:

- **Code**: `200 OK`
- **Content**: The updated recycling tip.

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `RecyclingTip with id {id} not found`

### Delete Recycling Tip

**Success Response**:

- **Code**: `204 NO CONTENT`

**Error Response**:

- **Code**: `404 NOT FOUND`
- **Content**: `RecyclingTip with id {id} not found`

### Get All Recycling Tip By Category Id

**Success Response**:

- **Code**: `200 OK`
- **Content**: `All Recycling Tip with `


## Error Handling

The application includes global exception handling to manage and provide meaningful error responses for various scenarios such as resource not found, validation errors, and conflict errors. This ensures that clients receive consistent and informative error messages.

