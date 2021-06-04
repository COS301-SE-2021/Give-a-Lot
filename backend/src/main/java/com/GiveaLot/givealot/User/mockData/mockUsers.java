package com.GiveaLot.givealot.User.mockData;
import com.GiveaLot.givealot.User.dataclass.User;
import java.util.LinkedList;
import java.util.List;

public class mockUsers
{
    List<User> users;

    public mockUsers()
    {
        users = new LinkedList<>();
        users.add(new User("the givers of hope",
                "give hope to the lost, and this and that and that other thing to make what what make sure",
                "givers@hope.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org1.jpg",
                "public/resources/ui/logo.png",
                 "givealot",
                 "Social Service",
                false,
                false));

        users.add(new User("Society of St Vincent de Paul",
                "Society of St Vincent de Pau, fighting hunger and this and that and that other thing to make what what make sure",
                "society@paul.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org2.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Poverty Alleviation",
                false,
                false));

        users.add(new User("The Hermanus Frail Care Centre",
                "Our elderly come first, bla bla bla and that and that other thing to make what what make sure",
                "Hermanus@Care.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org3.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Old Age Care",
                false,
                false));

        users.add(new User("ACVV Port Elizabeth Suid",
                "They are our future, the children, so what I man they will grow up and make mistakes nla bla bla  okay we end here make sure",
                "Elizabeth@Suid.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org4.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Children",
                false,
                false));

        users.add(new User("ACVV Port Elizabeth Suid 2",
                "They are our future, the children, this is our second division: so what I man they will grow up and make mistakes nla bla bla  okay we end here make sure",
                "Elizabeth@Suid.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org8.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Children",
                false,
                false));

        users.add(new User("ACVV Port Elizabeth Suid 3",
                "They are our future, the children, this is our third division: so what I man they will grow up and make mistakes nla bla bla  okay we end here make sure man they will grow up and make mistake",
                "Elizabeth@Suid.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org6.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Children",
                false,
                false));

        users.add(new User("St.Francis Care Centre",
                "Your health comes first, we at St Francis care centre make sure of thast covid covid, jump in the mathafakin jet like that",
                "contact@Francis.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org5.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Health",
                false,
                false));

        users.add(new User("St.Francis Care unit rangers",
                "We are the rangers, we make sure bla bla bla go go power rangers hey hey hey hey mock mock description",
                "unit@rangers.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org7.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "Health",
                false,
                false));

        users.add(new User("Gay and Lesbian Network",
                "gay peopel should be accepted in the society, everyone has a freedom of choice to... okay why are you geh? who's geh, you are geh?",
                "Gay@Network.com",
                "givers street,pretoria,South Afriza",
                "public/resources/images/org6.1.jpg",
                "public/resources/ui/logo.png",
                "givealot",
                "LGBTQ",
                false,
                false));

    }

    public List<User> getUsers()
    {
        return users;
    }

}
