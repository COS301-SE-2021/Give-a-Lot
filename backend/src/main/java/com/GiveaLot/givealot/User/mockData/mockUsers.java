package com.GiveaLot.givealot.User.mockData;
import com.GiveaLot.givealot.User.dataclass.User;
import java.util.LinkedList;
import java.util.List;

public class mockUsers
{
    List<User> users_list;
    List<User> users_detailed;

    public mockUsers()
    {
        users_list = new LinkedList<>();
       //
        users_list.add(new User("the givers of hope",
                "Restoring hope to the youth",
                "here is a short description of what the organization does and what it's about.there is a word requirement and limit. else the ui will not be consistent",
                "community",true,
                "src/assets/images/organisations/unique1/logo/1.jpg",
                "unique1"));

        users_list.add(new User("Food drive heros",
                "Restoring hope to the youth",
                "here is a short description of what the organization does and what it's about.there is a word requirement and limit. else the ui will not be consistent",
                "community",true,
                "src/assets/images/organisations/unique2/logo/1.jpg",
                "unique1"));

        users_list.add(new User("the givers of hope",
                "Restoring hope to the youth",
                "here is a short description of what the organization does and what it's about.there is a word requirement and limit. else the ui will not be consistent",
                "community",true,
                "src/assets/images/organisations/unique3/logo/1.jpg",
                "unique2"));

        users_list.add(new User("the givers of hope",
                "Restoring hope to the youth",
                "here is a short description of what the organization does and what it's about.there is a word requirement and limit. else the ui will not be consistent",
                "community",true,
                "src/assets/images/organisations/unique4/logo/1.jpg",
                "unique3"));
    }

    public List<User> getUsersListView()
    {
        return users_list;
    }
    public List<User> getUsersDetailedView()
    {
        return users_detailed;
    }
}