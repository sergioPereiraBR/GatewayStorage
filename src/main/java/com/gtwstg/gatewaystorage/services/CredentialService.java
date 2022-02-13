package com.gtwstg.gatewaystorage.services;

import com.azure.core.util.Configuration;

public class CredentialService {
    static String getAccountName() {
        return Configuration.getGlobalConfiguration().get("PRIMARY_STORAGE_ACCOUNT_NAME");
    }

    static String getAccountKey() {
        return Configuration.getGlobalConfiguration().get("PRIMARY_STORAGE_ACCOUNT_KEY");
    }
}
