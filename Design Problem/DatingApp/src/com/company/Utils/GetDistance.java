package com.company.Utils;

import com.company.model.Location;

public class GetDistance {

    public static int getDistance(Location firstUser, Location secondUser) {
        return (int) Math.sqrt(((firstUser.getxCordinet() - secondUser.getxCordinet())
                * (firstUser.getxCordinet() - secondUser.getxCordinet()) +
                (firstUser.getyCordinet() - secondUser.getyCordinet())
                * (firstUser.getyCordinet() - secondUser.getyCordinet())));
    }

}