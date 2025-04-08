trigger AccountTrigger on Account (before insert, after insert, before update, after update, before delete, after delete) {
    if (Trigger.isBefore) {
        if (Trigger.isInsert) {
            // Code to execute before inserting new Accounts
            for (Account acc : Trigger.new) {
                acc.Name = acc.Name + ' - New Account';
            }
        }
        if (Trigger.isUpdate) {
            // Code to execute before updating Accounts
            for (Account acc : Trigger.new) {
                acc.Description = 'Updated account';
            }
        }
    }

    if (Trigger.isAfter) {
        if (Trigger.isInsert) {
            // Code to execute after inserting new Accounts
            for (Account acc : Trigger.new) {
                System.debug('Account inserted: ' + acc.Name);
            }
        }
        if (Trigger.isUpdate) {
            // Code to execute after updating Accounts
            for (Account acc : Trigger.new) {
                System.debug('Account updated: ' + acc.Name);
            }
        }
    }
}
