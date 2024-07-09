# Online Dating Application

## Problem Statement

Create an online dating application. Every active user account will have location, age, and gender info. The app should show users their potential matches in order of relevance. The ordering of relevance will be the following:

1. **Gender**: Opposite gender -> high priority.
2. **Proximity**: Nearer matches should be given more priority. Use the following formula for computing the distance between two locations:

    dist([x, y], [a, b]) = sqrt((x - a)^2 + (y - b)^2)


3. **Age**: Less age difference -> high priority.

## Operations

A user can perform these operations in this application:

1. **Create Account**: A person can create an account with interest and profile details.
2. **Potential Match**: Provides all the potential matches of a user in relevance order.
3. **Like**: User can like a potential match user.
4. **Show Matches**: Showing the users which match against a user. A match happens when both the users have liked each other.
5. **Show All Matches**: Showing system view by displaying all the matches in the system.
6. **Ignore**: User can ignore a potential match user.
7. **Delete Account**: If a user deletes the account, then all matches and likes will be removed.

## Use Case

1. If a user A likes user B, the data should be stored for further processing.
2. All the matches (cases where two users have liked each other) in the system should be shown.

## Implementation Details

### Data Model

- **User**: Represents a user in the system with attributes such as name, age, gender, location, and list of liked users.
- **Location**: Represents the geographical location of a user with x and y coordinates.
- **Match**: Represents a mutual like between two users.

### Classes and Methods

- **User**:
- `createAccount(userDetails)`: Registers a new user.
- `likeUser(targetUserId)`: Likes a potential match user.
- `ignoreUser(targetUserId)`: Ignores a potential match user.
- `deleteAccount(user)`: Deletes the user account and removes all matches and likes.

- **MatchService**:
- `findPotentialMatches(userId)`: Finds all potential matches for a user.
- `showMatches(userId)`: Shows all matches for a user.
- `showAllMatches()`: Shows all matches in the system.

