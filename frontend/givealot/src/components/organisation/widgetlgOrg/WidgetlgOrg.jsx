import "./widgetlgOrg.css";

export default function WidgetLgOrg() {
  const Button = ({ type }) => {
    return <button className={"widgetLgButtonOrg " + type}>{type}</button>;
  };
  return (
    <div className="widgetLgOrg">
      <h3 className="widgetLgTitleOrg">Latest transactions</h3>
      <table className="widgetLgTableOrg">
        <tr className="widgetLgTrOrg">
          <th className="widgetLgThOrg">Customer</th>
          <th className="widgetLgThOrg">Date</th>
          <th className="widgetLgThOrg">Amount</th>
          <th className="widgetLgThOrg">Status</th>
        </tr>
        <tr className="widgetLgTrOrg">
          <td className="widgetLgUserOrg">
            <img
              src="https://images.pexels.com/photos/4172933/pexels-photo-4172933.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
              alt=""
              className="widgetLgImgOrg"
            />
            <span className="widgetLgNameOrg">Susan Carol</span>
          </td>
          <td className="widgetLgDateOrg">2 Jun 2021</td>
          <td className="widgetLgAmountOrg">$122.00</td>
          <td className="widgetLgStatusOrg">
            <Button type="Approved" />
          </td>
        </tr>
        <tr className="widgetLgTrOrg">
          <td className="widgetLgUserOrg">
            <img
              src="https://images.pexels.com/photos/4172933/pexels-photo-4172933.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
              alt=""
              className="widgetLgImgOrg"
            />
            <span className="widgetLgNameOrg">Susan Carol</span>
          </td>
          <td className="widgetLgDateOrg">2 Jun 2021</td>
          <td className="widgetLgAmountOrg">$122.00</td>
          <td className="widgetLgStatusOrg">
            <Button type="Declined" />
          </td>
        </tr>
        <tr className="widgetLgTrOrg">
          <td className="widgetLgUserOrg">
            <img
              src="https://images.pexels.com/photos/4172933/pexels-photo-4172933.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
              alt=""
              className="widgetLgImgOrg"
            />
            <span className="widgetLgNameOrg">Susan Carol</span>
          </td>
          <td className="widgetLgDateOrg">2 Jun 2021</td>
          <td className="widgetLgAmountOrg">$122.00</td>
          <td className="widgetLgStatusOrg">
            <Button type="Pending" />
          </td>
        </tr>
        <tr className="widgetLgTrOrg">
          <td className="widgetLgUserOrg">
            <img
              src="https://images.pexels.com/photos/4172933/pexels-photo-4172933.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
              alt=""
              className="widgetLgImgOrg"
            />
            <span className="widgetLgNameOrg">Susan Carol</span>
          </td>
          <td className="widgetLgDateOrg">2 Jun 2021</td>
          <td className="widgetLgAmountOrg">$122.00</td>
          <td className="widgetLgStatusOrg">
            <Button type="Approved" />
          </td>
        </tr>
      </table>
    </div>
  );
}