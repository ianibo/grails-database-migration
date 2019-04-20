import org.grails.plugins.databasemigration.DatabaseMigrationException
import org.grails.plugins.databasemigration.command.DbmCreateChangelog

import grails.dev.commands.*

class dbmChangelogToGroovy implements GrailsApplicationCommand {

  boolean handle(ExecutionContext executionContext) {
    try {
        new DbmCreateChangelog().handle(executionContext)
    } catch (DatabaseMigrationException e) {
        error e.message, e
    }
  }
