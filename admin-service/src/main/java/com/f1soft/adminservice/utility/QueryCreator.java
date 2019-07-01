package com.f1soft.adminservice.utility;

import com.f1soft.adminservice.requestDTO.AdminRequestDTO;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class QueryCreator {

    public static Supplier<String> createQueryToFetchAdminsToSendEmail = () ->
            " SELECT a.id, a.email_address FROM admin a WHERE a.email_sent = 'N'";

    public static Function<AdminRequestDTO, String> createQueryToFetchAdminDetails = (requestDTO) -> {

        String query = "";

        query = " SELECT a.id," +                            //[0]
                " a.password," +                            //[1]
                " a.status," +                             //[2]
                " a.login_attempt," +                       //[3]
                " a.email_address" +                        //[4]
                " FROM" +
                " admin a" +
                " WHERE" +
                " a.id!=0";

        if (!Objects.isNull(requestDTO.getUsername()))
            query += " AND a.username= '" + requestDTO.getUsername() + "'";

        if (!Objects.isNull(requestDTO.getEmailAddress()))
            query += " AND a.email_address= '" + requestDTO.getEmailAddress() + "'";

        return query;
    };
}
