package datenbanken.database.entries;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import datenbanken.database.entries.Bankverbindung;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.SqlTypes;
import org.hibernate.usertype.UserType;

public class BankverbindungType implements UserType<Bankverbindung> {

    @Override
    public int getSqlType() {
        return SqlTypes.VARCHAR;
    }

    @Override
    public Class<Bankverbindung> returnedClass() {
        return Bankverbindung.class;
    }

    @Override
    public boolean equals(Bankverbindung x, Bankverbindung y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Bankverbindung x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Bankverbindung nullSafeGet(ResultSet resultSet, int i, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws SQLException {
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Bankverbindung bankverbindung, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (bankverbindung == null) {
            preparedStatement.setNull(index, Types.VARCHAR);
            preparedStatement.setNull(index + 1, Types.VARCHAR);
            preparedStatement.setNull(index + 2, Types.VARCHAR);
        } else {
            preparedStatement.setString(index, bankverbindung.getName());
            preparedStatement.setString(index + 1, bankverbindung.getBic());
            preparedStatement.setString(index + 2, bankverbindung.getIban());
        }
    }

    @Override
    public Bankverbindung deepCopy(Bankverbindung bankverbindung) {
        if (bankverbindung == null) {
            return null;
        }
        return new Bankverbindung(bankverbindung.getName(), bankverbindung.getBic(), bankverbindung.getIban());
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Bankverbindung bankverbindung) {
        return bankverbindung;
    }

    @Override
    public Bankverbindung assemble(Serializable serializable, Object o) {
        return (Bankverbindung) serializable;
    }
}