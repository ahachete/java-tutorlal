/*
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
 * disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


package org.postgresql.ext.javatutorial.solutions;


import org.openjdk.jmh.runner.RunnerException;
import org.postgresql.ext.javatutorial.common.util.MainUtil;
import org.postgresql.ext.javatutorial.solutions._02_inserts._01.StatementInserts;
import org.postgresql.ext.javatutorial.solutions._02_inserts._02.PreparedInserts;
import org.postgresql.ext.javatutorial.solutions._02_inserts._03.BatchedInserts;
import org.postgresql.ext.javatutorial.solutions._02_inserts._04.Copy;
import org.postgresql.ext.javatutorial.solutions._01_selects._01.BasicTypesSelect;
import org.postgresql.ext.javatutorial.solutions._01_selects._02.JsonSelect;
import org.postgresql.ext.javatutorial.solutions._01_selects._03.ArraysSelect;


public class Main {
    public enum Benchmarks {
        /* Block 1 */
        StatementInserts(StatementInserts.class),
        PreparedInserts(PreparedInserts.class),
        BatchedInserts(BatchedInserts.class),
        Copy(Copy.class),

        /* Block 2 */
        BasicTypesSelect(BasicTypesSelect.class),
        JsonSelect(JsonSelect.class),
        ArraysSelect(ArraysSelect.class)

        ;

        private final Class<?> clazz;

        Benchmarks(Class<?> clazz) {
            this.clazz = clazz;
        }
    }

    public static void main(String[] args) throws RunnerException {
        MainUtil.run(Benchmarks.valueOf(args[0]).clazz);
    }
}
