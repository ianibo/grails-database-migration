/*
 * Copyright 2015 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.databasemigration.liquibase

import groovy.transform.CompileStatic
import liquibase.logging.LogLevel
import liquibase.logging.core.AbstractLogger
import liquibase.util.StringUtils
import liquibase.logging.LogType;

import java.util.logging.Level;

import java.text.DateFormat

@CompileStatic
class StandardOutLogger extends AbstractLogger {

    final int priority = 5

    String name

    protected void print(LogLevel logLevel, String message) {
        if (StringUtils.trimToNull(message) == null) {
            return
        }

        println("${logLevel} ${DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date())}: ${name}: ${message}")
    }

    private java.util.logging.Logger logger;


    public JavaLogger(java.util.logging.Logger logger) {
        this.logger = logger;
    }

    public void debug(liquibase.logging.LogType target, java.lang.String message) {
      this.debug(message)
    }

    public void debug(liquibase.logging.LogType target, java.lang.String message, Throwable e) {
      this.debug(message,e)
    }

    @Override
    public void severe(String message) {
        this.severe(LogType.LOG, message);
    }

    @Override
    public void severe(LogType target, String message) {
        this.severe(target, message, null);
    }

    @Override
    public void severe(LogType target, String message, Throwable e) {
        this.severe(target, message, e);
    }

    @Override
    public void severe(String message, Throwable e) {
        this.severe(LogType.LOG, message, e);
    }

    @Override
    public void warning(String message) {
        this.warning(LogType.LOG, message);
    }

    @Override
    public void warning(String message, Throwable e) {
        this.warning(LogType.LOG, message, e);
    }

    @Override
    public void warning(LogType target, String message) {
        this.warning(target, message, null);
    }

    @Override
    public void warning(LogType target, String message, Throwable e) {
        this.warning(target, message, e);
    }

    @Override
    public void info(String message) {
        this.info(LogType.LOG, message);
    }

    @Override
    public void info(String message, Throwable e) {
        this.info(LogType.LOG, message, e);
    }

    @Override
    public void info(LogType logType, String message) {
        this.info(logType, message, null);
    }

    @Override
    public void info(LogType target, String message, Throwable e) {
        this.info(target, message, e);

    }

}
