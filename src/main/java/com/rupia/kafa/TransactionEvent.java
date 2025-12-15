package com.rupia.kafa;


/**
 * Created by Ram Mandal on 15/12/2025
 *
 * @System: Apple M1 Pro
 */
public sealed interface TransactionEvent
        permits WalletReloadEvent, TransferMoneyEvent {
}
